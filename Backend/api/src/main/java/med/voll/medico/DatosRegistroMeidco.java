package med.voll.medico;

import med.voll.direccion.Direccion;

public record DatosRegistroMeidco(
        String nombre,
        String email,
        String documento,
        Especialidad especialidad,
        Direccion direccion
) {
}
