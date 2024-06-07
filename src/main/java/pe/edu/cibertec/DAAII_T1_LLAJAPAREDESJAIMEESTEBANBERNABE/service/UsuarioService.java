package pe.edu.cibertec.DAAII_T1_LLAJAPAREDESJAIMEESTEBANBERNABE.service;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DAAII_T1_LLAJAPAREDESJAIMEESTEBANBERNABE.model.bd.Rol;
import pe.edu.cibertec.DAAII_T1_LLAJAPAREDESJAIMEESTEBANBERNABE.model.bd.Usuario;
import pe.edu.cibertec.DAAII_T1_LLAJAPAREDESJAIMEESTEBANBERNABE.repository.RolRepository;
import pe.edu.cibertec.DAAII_T1_LLAJAPAREDESJAIMEESTEBANBERNABE.repository.UsuarioRepository;
import pe.edu.cibertec.DAAII_T1_LLAJAPAREDESJAIMEESTEBANBERNABE.util.RandomPassword;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
@AllArgsConstructor
public class UsuarioService implements IUsuarioService {

    private UsuarioRepository usuarioRepository;
    private RolRepository rolRepository;
    private RandomPassword randomPassword;

    @Override
    public Usuario buscarUsuarioXNomUsuario(String nomusuario) {
        return usuarioRepository.findByNomusuario(nomusuario);
    }
    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        usuario.setActivo(true);
        Rol usuarioRol = rolRepository.findByNomrol("ADMIN");
        usuario.setRoles(new HashSet<>(Arrays.asList(usuarioRol)));
        usuario.setPassword(passwordEncoder.encode(randomPassword.generar(7)));
        return usuarioRepository.save(usuario);
    }

    @Override
    public void actualizarContraseña(Integer idusuario, String nuevaContraseña) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String contraseñaCodificada = passwordEncoder.encode(nuevaContraseña);
        usuarioRepository.actualizarContraseña(idusuario, contraseñaCodificada);
    }
    @Override
    public List<Usuario> listarUsuario() {
        return usuarioRepository.findAll();
    }
    @Override
    public Usuario buscarUsuarioXIdUsuario(Integer idusuario) {
        return usuarioRepository.findById(idusuario).orElse(null);
    }
}
