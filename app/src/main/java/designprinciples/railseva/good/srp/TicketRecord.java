package designprinciples.railseva.good.srp;

// 1. Domain Data Model: Represents ticket state
public record TicketRecord(String pnr, String trainNo, double distanceKm, String passenger) {}