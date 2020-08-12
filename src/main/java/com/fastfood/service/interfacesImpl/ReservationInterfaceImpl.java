//package com.fastfood.service.interfacesImpl;
//
//import com.fastfood.Repository.ReservationRepository;
//import com.fastfood.model.DTO.ReservationDTO;
//import com.fastfood.model.Reservation;
//import com.fastfood.service.interfaces.ReservationInterface;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.UUID;
//
//@Service
//public class ReservationInterfaceImpl implements ReservationInterface {
//
//    private final ReservationRepository reservationRepository;
//
//    public ReservationInterfaceImpl(ReservationRepository reservationRepository) {
//        this.reservationRepository = reservationRepository;
//    }
//
//    @Override
//    public List<Reservation> fetchReservations() {
//        return reservationRepository.findAll();
//    }
//
//    @Override
//    public void saveReservation(ReservationDTO reservationDTO) {
//        Reservation r = new Reservation(UUID.randomUUID().toString(), reservationDTO.getDate(), reservationDTO.getTime(),
//                reservationDTO.getPersons(), reservationDTO.getName(), reservationDTO.getClientMessage());
//
//        reservationRepository.save(r);
//    }
//
//    @Override
//    public void deleteReservation(String id) {
//        reservationRepository.deleteById(id);
//    }
//}
