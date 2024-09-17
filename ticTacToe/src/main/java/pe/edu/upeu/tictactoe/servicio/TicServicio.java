package pe.edu.upeu.tictactoe.servicio;

import pe.edu.upeu.tictactoe.modelo.ModelTic;

import java.util.List;

public interface TicServicio {
    public void guardarNombre(ModelTic tic);
    public List<ModelTic> obtenerNombre();
    
}
