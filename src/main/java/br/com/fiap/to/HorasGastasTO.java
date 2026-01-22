package br.com.fiap.to;

import java.time.LocalDate;
import java.time.LocalTime;

public class HorasGastasTO {

    private long id;
    private LocalDate data;
    private LocalTime horaInicio;
    private LocalTime horaFim;
    private long userId;
    private String userNome;

    public HorasGastasTO() {}

    public HorasGastasTO(long id, LocalDate data, LocalTime horaInicio, LocalTime horaFim, long userId, String userNome) {
        this.id = id;
        this.data = data;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.userId = userId;
        this.userNome = userNome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(LocalTime horaFim) {
        this.horaFim = horaFim;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserNome() {
        return userNome;
    }

    public void setUserNome(String userNome) {
        this.userNome = userNome;
    }
}
