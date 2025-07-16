package med.voll.direccion;

public record Direccion(
        String calle,
        String numero,
        String complemento,
        String barrio,
        String codigoPostal,
        String ciudad,
        String estado
) {
}
