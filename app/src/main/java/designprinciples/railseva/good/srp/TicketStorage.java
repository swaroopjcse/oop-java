package designprinciples.railseva.good.srp;

// 3. Infrastructure Persistence: Changes ONLY when database tech changes
public interface TicketStorage {
    void store(TicketRecord ticket, double finalFare);
}