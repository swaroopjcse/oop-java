package designprinciples.railseva.good.srp;

// 4. Passenger Communications: Changes ONLY when messaging providers change
public interface PassengerAlertService {
    void notifyBooking(String mobileNo, String pnr);
}