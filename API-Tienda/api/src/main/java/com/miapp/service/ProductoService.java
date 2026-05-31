package com.miapp.service;

import com.miapp.dto.CategoriaOptionDto;
import com.miapp.dto.ProductoResponseDto;
import com.miapp.model.Categoria;
import com.miapp.model.Producto;
import com.miapp.repository.CategoriaRepository;
import com.miapp.repository.ProductoRepository;
import com.miapp.util.ImagesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<ProductoResponseDto> obtenerCatalogo() {
        List<Producto> productos = productoRepository.findAll();
        Map<Long, String> categoriasPorId = construirMapaCategorias();
        return productos.stream()
                .map(producto -> toResponseDto(producto, categoriasPorId))
                .collect(Collectors.toList());
    }

    public Optional<ProductoResponseDto> obtenerProductoPorId(Integer id) {
        return productoRepository.findById(id).map(this::toResponseDto);
    }

    public Optional<Producto> obtenerProductoEntidadPorId(Integer id) {
        return productoRepository.findById(id);
    }

    public ProductoResponseDto guardarProducto(Producto producto) {
        Producto saved = productoRepository.save(producto);
        return toResponseDto(saved);
    }

    public void eliminarProducto(Integer id) {
        Optional<Producto> producto = productoRepository.findById(id);
        if (producto.isPresent() && producto.get().getImagen() != null) {
            ImagesUtil.eliminarImagen(producto.get().getImagen());
        }
        productoRepository.deleteById(id);
    }

    public List<Producto> buscarPorCategoria(Long categoria) {
        return productoRepository.findByCategoria(categoria);
    }

    public List<Producto> buscarPorNombre(String nombre) {
        return productoRepository.findByNombreContainingIgnoreCase(nombre);
    }

    public List<CategoriaOptionDto> obtenerCategorias() {
        return categoriaRepository.findAll().stream()
                .sorted((a, b) -> a.getNombre().compareToIgnoreCase(b.getNombre()))
                .map(categoria -> new CategoriaOptionDto(categoria.getId(), categoria.getNombre()))
                .collect(Collectors.toList());
    }

    public ProductoResponseDto guardarProductoConImagen(Producto producto, MultipartFile imagenFile) throws Exception {
        String imagenAnterior = null;
        
        if (producto.getId() != null && producto.getId() > 0) {
            Optional<Producto> productoExistente = productoRepository.findById(producto.getId());
            if (productoExistente.isPresent()) {
                imagenAnterior = productoExistente.get().getImagen();
            }
        }

        if (imagenFile != null && !imagenFile.isEmpty()) {
            String nombreImagen = ImagesUtil.guardarImagen(imagenFile);
            if (imagenAnterior != null && !imagenAnterior.isEmpty()) {
                ImagesUtil.eliminarImagen(imagenAnterior);
            }
            producto.setImagen(nombreImagen);
        } else if (imagenAnterior != null && !imagenAnterior.isEmpty()) {
            producto.setImagen(imagenAnterior);
        }

        Producto saved = productoRepository.save(producto);
        return toResponseDto(saved);
    }

    private ProductoResponseDto toResponseDto(Producto producto) {
        String nombreCategoria = "";
        if (producto.getCategoria() != null) {
            nombreCategoria = categoriaRepository.findById(producto.getCategoria())
                    .map(Categoria::getNombre)
                    .orElse(String.valueOf(producto.getCategoria()));
        }
        return new ProductoResponseDto(
                producto.getId(),
                producto.getNombre(),
                producto.getStock(),
                producto.getPrecio(),
                nombreCategoria,
                producto.getDescripcion(),
                producto.getImagen()
        );
    }

    private ProductoResponseDto toResponseDto(Producto producto, Map<Long, String> categoriasPorId) {
        String nombreCategoria = "";
        Long categoriaId = producto.getCategoria();
        if (categoriaId != null) {
            nombreCategoria = categoriasPorId.getOrDefault(categoriaId, String.valueOf(categoriaId));
        }
        return new ProductoResponseDto(
                producto.getId(),
                producto.getNombre(),
                producto.getStock(),
                producto.getPrecio(),
                nombreCategoria,
                producto.getDescripcion(),
                producto.getImagen()
        );
    }

    private Map<Long, String> construirMapaCategorias() {
        List<Categoria> categorias = categoriaRepository.findAll();
        if (categorias.isEmpty()) {
            return Collections.emptyMap();
        }

        Map<Long, String> categoriasPorId = new HashMap<>();
        for (Categoria categoria : categorias) {
            categoriasPorId.put(categoria.getId(), categoria.getNombre());
        }
        return categoriasPorId;
    }
}