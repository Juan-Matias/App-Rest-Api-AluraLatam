package med.voll.controller;

import jakarta.validation.Valid;
import med.voll.medico.DatosRegistroMedico;
import med.voll.medico.Medico;
import med.voll.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    //Pueda crear una instancion que tenga heredado de esa interfaz
    @Autowired
    private MedicoRepository repository;

    //Vamos estar haciendo modificaciones en la base de datos
    //Por eso usamos esta Anotacion
    @Transactional
    //metodo Post
    @PostMapping
    public void registrar(@RequestBody @Valid DatosRegistroMedico datos) {
      repository.save(new Medico(datos));
    }
}
