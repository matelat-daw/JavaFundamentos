package com.miapp.controller;

import com.miapp.dto.CategoriaOptionDto;
import com.miapp.dto.ProductoRequestDto;
import com.miapp.dto.ProductoResponseDto;
import com.miapp.model.Producto;
import com.miapp.dto.ProductoUpdateDto;
import com.miapp.service.ProductoService;
import com.miapp.util.ImagesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductApiController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/products")
    public List<ProductoResponseDto> list() {
        return productoService.obtenerCatalogo();
    }

    @GetMapping("/categorias")
    public List<CategoriaOptionDto> categorias() {
        return productoService.obtenerCategorias();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductoResponseDto> get(@PathVariable int id) {
        Optional<ProductoResponseDto> p = productoService.obtenerProductoPorId(id);
        return p.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/products")
    public ResponseEntity<ProductoResponseDto> create(@RequestBody ProductoRequestDto productoDto) {
        Producto producto = new Producto();
        producto.setNombre(productoDto.getNombre());
        producto.setPrecio(productoDto.getPrecio());
        producto.setStock(productoDto.getStock() != null ? productoDto.getStock() : 0);
        producto.setCategoria(productoDto.getCategoria());
        producto.setDescripcion(productoDto.getDescripcion());
        producto.setImagen(productoDto.getImagen());

        ProductoResponseDto saved = productoService.guardarProducto(producto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<ProductoResponseDto> update(@PathVariable int id, @RequestBody ProductoUpdateDto productoDto) {
        try {
            Optional<Producto> existing = productoService.obtenerProductoEntidadPorId(id);
            if (!existing.isPresent()) return ResponseEntity.notFound().build();
            
            Producto target = existing.get();
            target.setId(id);  // Asegurar que el ID esté establecido
            if (productoDto.getNombre() != null) target.setNombre(productoDto.getNombre());
            if (productoDto.getStock() != null) target.setStock(productoDto.getStock());
            if (productoDto.getPrecio() != null) target.setPrecio(productoDto.getPrecio());
            if (productoDto.getCategoria() != null) target.setCategoria(productoDto.getCategoria());
            if (productoDto.getDescripcion() != null) target.setDescripcion(productoDto.getDescripcion());
            if (productoDto.getImagen() != null && !productoDto.getImagen().isBlank()) {
                target.setImagen(productoDto.getImagen());
            }
            ProductoResponseDto saved = productoService.guardarProducto(target);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        Optional<Producto> existing = productoService.obtenerProductoEntidadPorId(id);
        if (!existing.isPresent()) return ResponseEntity.notFound().build();
        productoService.eliminarProducto(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/products/{id}/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ProductoResponseDto> uploadImage(@PathVariable int id, @RequestPart("imagen") MultipartFile imagen) {
        try {
            Optional<Producto> existing = productoService.obtenerProductoEntidadPorId(id);
            if (!existing.isPresent()) {
                return ResponseEntity.notFound().build();
            }
            
            Producto producto = existing.get();
            producto.setId(id);
            ProductoResponseDto saved = productoService.guardarProductoConImagen(producto, imagen);
            return ResponseEntity.ok(saved);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/imgs/{filename:.+}")
    public ResponseEntity<byte[]> getImage(@PathVariable String filename) {
        try {
            Path path = ImagesUtil.getUploadDirPath().resolve(filename);
            if (!Files.exists(path)) return ResponseEntity.notFound().build();
            String contentType = Files.probeContentType(path);
            byte[] bytes = Files.readAllBytes(path);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType(contentType != null ? contentType : "application/octet-stream"));
            return new ResponseEntity<>(bytes, headers, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
