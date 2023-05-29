package com.credibanco.firstapp.controller;

import com.credibanco.firstapp.dto.UsuarioDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    // Crear un mapa para almacenar usuarios
    Map<String, String> mapUsers = new HashMap<>();

    // Método POST para crear un nuevo usuario
    @PostMapping("/create")
    public ResponseEntity<Object> createUser(@RequestBody UsuarioDTO usuarioDTO) {
        // Almacenar los datos del usuario en el mapa
        mapUsers.put("1", usuarioDTO.getNombre());
        mapUsers.put("2", usuarioDTO.getApellido());
        mapUsers.put("3", usuarioDTO.getVehiculo() + "");

        // Devolver una respuesta con el estado OK y el mapa de usuarios como cuerpo
        return ResponseEntity.status(HttpStatus.OK).body(mapUsers);
    }

    // Método GET para obtener un usuario por su ID
    @GetMapping("/read/{id}")
    public ResponseEntity<Object> createUser(@PathVariable String id) {
        // Verificar si el mapa contiene la clave (ID) solicitada
        // Si existe, se devuelve el usuario correspondiente; de lo contrario, se devuelve "No existe"
        return ResponseEntity.status(mapUsers.containsKey(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND)
                .body(mapUsers.containsKey(id) ? mapUsers.get(id) : "No existe");
    }

    // Método PUT para actualizar un usuario existente
    @PutMapping("/update")
    public ResponseEntity<Object> updateUser(@RequestBody UsuarioDTO usuarioDTO) {
        // Actualizar los datos del usuario en el mapa
        mapUsers.put("1", usuarioDTO.getNombre());
        mapUsers.put("2", usuarioDTO.getApellido());
        mapUsers.put("3", usuarioDTO.getVehiculo() + "");

        // Devolver una respuesta con el estado OK y el mapa de usuarios como cuerpo
        return ResponseEntity.status(HttpStatus.OK).body(mapUsers);
    }

    // Método DELETE para eliminar un usuario por su ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable String id) {
        // Eliminar el usuario del mapa utilizando su ID
        mapUsers.remove(id);

        // Devolver una respuesta con el estado OK y el mensaje "Eliminado" como cuerpo
        return ResponseEntity.status(HttpStatus.OK).body("Eliminado");
    }
}

