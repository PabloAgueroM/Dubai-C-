/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import AccesoDatos.UsuarioDA;
import Modelo.Usuario;
import java.util.ArrayList;

/**
 *
 * @author alulab14
 */
public class UsuarioBL {
    
    private UsuarioDA accesoDatos;

        public UsuarioBL() { accesoDatos = new UsuarioDA(); }

        public int registrarUsuario(Usuario u)
        {
            return accesoDatos.registrarUsuario(u);
        }

        public ArrayList<Usuario> listarUsuarios()
        {
            return accesoDatos.listarUsuarios();
        }
        public ArrayList<Usuario> listarTodosUsuarios()
        {
            return accesoDatos.listarTodosUsuarios();
        }

        public void eliminarUsuario(String id)
        {
            accesoDatos.eliminarUsuario(id);
        }

        public int modificarUsuario(Usuario user)
        {
            return accesoDatos.modificarUsuario(user);
        }
    
}
