package med.voll.controller;

import med.voll.medico.DatosRegistroMeidco;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    //metodo Post
    @PostMapping
    public void registrar(@RequestBody DatosRegistroMeidco datos) {
        System.out.println("datos recibidos: " +datos);
    }
}
