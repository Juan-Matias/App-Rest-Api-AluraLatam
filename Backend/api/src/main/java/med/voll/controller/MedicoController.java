package med.voll.controller;

import jakarta.validation.Valid;
import med.voll.medico.DatosListaMedico;
import med.voll.medico.DatosRegistroMedico;
import med.voll.medico.Medico;
import med.voll.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    //Pueda crear una instancion que tenga heredado de esa interfaz
    @Autowired
    private MedicoRepository repository;

    //Vamos estar haciendo modificaciones en la base de datos
    //Por eso usamos esta Anotacion
    @Transactional
    //Verbo HTTP metodo Post
    @PostMapping
    public void registrar(@RequestBody @Valid DatosRegistroMedico datos) {

        repository.save(new Medico(datos));
    }

    // Maneja solicitudes HTTP GET hacia la URL "/medicos"
    @GetMapping
    public List<DatosListaMedico> listar() {
        // 1. Obtiene todos los registros de médicos desde la base de datos
        // 2. Convierte la lista de entidades Medico a una lista de DTOs DatosListaMedico
        //    usando programación funcional (stream y map)
        // 3. Retorna la lista transformada
        return repository.findAll().stream()
                .map(DatosListaMedico::new) // Transforma cada entidad Medico en un DTO DatosListaMedico
                .toList();                  // Convierte el Stream a una List
    }

}
