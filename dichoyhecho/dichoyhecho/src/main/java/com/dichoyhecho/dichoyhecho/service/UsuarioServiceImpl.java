package com.dichoyhecho.dichoyhecho.service;

import com.dichoyhecho.dichoyhecho.entity.Usuario;
import com.dichoyhecho.dichoyhecho.exception.ResourceNotFoundException;
import com.dichoyhecho.dichoyhecho.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario obtenerPorId(Integer id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario con Id no encontrado :" + id));
    }

    @Override
    public Usuario crear(Usuario usuario) {
        usuario.setIdUsuario(null);
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario actualizar(Integer id, Usuario usuario) {
        Usuario existente = obtenerPorId(id);
        existente.setNombreUsuario(usuario.getNombreUsuario());
        existente.setApellidoUsuario(usuario.getApellidoUsuario());
        existente.setHandleUsuario(usuario.getHandleUsuario());
        existente.setContrasena(usuario.getContrasena());
        existente.setEdadUsuario(usuario.getEdadUsuario());
        existente.setRolUsuario(usuario.getRolUsuario());

        return usuarioRepository.save(existente);
    }

    @Override
    public void eliminar(Integer id) {
        if (!usuarioRepository.existsById(id)) {
            throw new ResourceNotFoundException("Usuario con ID no encontrado: " + id);
        }
        usuarioRepository.deleteById(id);
    }
}
