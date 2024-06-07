package pe.edu.cibertec.DAAII_T1_LLAJAPAREDESJAIMEESTEBANBERNABE.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.DAAII_T1_LLAJAPAREDESJAIMEESTEBANBERNABE.model.bd.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    //Select * from usuario where nomusuario = ''
    Usuario findByNomusuario(String nomusuario);

    @Modifying
    @Transactional
    @Query("UPDATE Usuario u SET u.password = :password WHERE u.idusuario = :idusuario")
    void actualizarContraseña(@Param("idusuario") Integer idusuario, @Param("password") String password);
}
