package pe.edu.cibertec.DAAII_T1_LLAJAPAREDESJAIMEESTEBANBERNABE.model.dto;

import lombok.Data;

@Data
public class UsuarioDto {
    private Integer idusuario;
    private String nomusuario;
    private String nombres;
    private String apellidos;
    private Boolean activo;
    private String email;
}
