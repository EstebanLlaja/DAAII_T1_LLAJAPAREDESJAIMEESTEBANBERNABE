package pe.edu.cibertec.DAAII_T1_LLAJAPAREDESJAIMEESTEBANBERNABE.service;



import pe.edu.cibertec.DAAII_T1_LLAJAPAREDESJAIMEESTEBANBERNABE.model.bd.Usuario;

import java.util.List;

public interface IUsuarioService {

    Usuario buscarUsuarioXNomUsuario(String nomusuario);
    Usuario guardarUsuario(Usuario usuario);

    void actualizarContraseña(Integer idusuario, String nuevaContraseña);

    List<Usuario> listarUsuario();
    Usuario buscarUsuarioXIdUsuario(Integer idusuario);
}
