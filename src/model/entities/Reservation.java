package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    // Essa verificação "if" garante que as datas de check-in e check-out sejam válidas.
    // Isso se chama programação defensiva, onde tentamos evitar erros antes que eles ocorram.
    public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws model.entities.DomainException {
        if (checkIn.after(checkOut)) {
            throw new model.entities.DomainException("Check-out date must be after check-in date");
        }
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    // O método DAYS converte a diferença de milissegundos para dias

    public long duration() {
        long diff = checkOut.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    // Utilizamo uma exceção personalizada para tratar erros de domínio, como datas inválidas.

    public void updateDate(Date checkIn, Date checkOut) throws model.entities.DomainException {
        Date now = new Date();

        if (checkIn.before(now) || checkOut.before(now)) {
            throw new model.entities.DomainException("Reservation dates for update must be future dates ");
        }

        if (checkIn.after(checkOut)) {
            throw new model.entities.DomainException("Check-out date must be after check-in date");
        }

        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public String toString() {
        return "Room "
                + roomNumber
                + ", "
                + "check-in: "
                + sdf.format(checkIn) +
                ", check-in: "
                + sdf.format(checkOut) +
                ", check-out: "
                + ", "
                + duration()
                + " nights";
    }
}
