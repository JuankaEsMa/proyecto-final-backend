package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Usuario;
import com.example.demo.service.UsuarioService;

@RestController
@RequestMapping("usuario")
public class UsuarioController {
	@Autowired
	UsuarioService usuarioService;

	@GetMapping("")
	public List<Usuario> listUsuario() {
		// TODO Auto-generated method stub
		return usuarioService.listUsuario();
	}

	@PostMapping("")
	public Usuario addUsuario(@RequestBody Usuario usuario) {
		// TODO Auto-generated method stub
		return usuarioService.saveUsuario(usuario);
	}

	@PutMapping("/{id}")
	public Usuario updateUsuario(@PathVariable Integer id, @RequestBody Usuario usuario) {
		Usuario usuarioActualizar = usuarioService.getUsuario(id);

		usuarioActualizar.setNombre(usuario.getNombre());
		usuarioActualizar.setApellidos(usuario.getApellidos());
		usuarioActualizar.setTelefono(usuario.getTelefono());
		usuarioActualizar.setDni(usuario.getDni());
		usuarioActualizar.setDireccion(usuario.getDireccion());
		usuarioActualizar.setEmail(usuario.getEmail());
		usuarioActualizar.setFechaNacimiento(usuario.getFechaNacimiento());
		usuarioActualizar.setDeleted(usuario.isDeleted());
		usuarioActualizar.setApellidos(usuario.getApellidos());

		return usuarioActualizar;
	}

	@GetMapping("/{id}")
	public Usuario showUsuario(@PathVariable Integer id) {
		// TODO Auto-generated method stub
		return usuarioService.getUsuario(id);
	}

	@DeleteMapping("/{id}")
	public void deleteUsuario(@PathVariable Integer id) {
		// TODO Auto-generated method stub
		usuarioService.deleteUsuario(id);
	}
}