package designprinciples.railseva.good.lsp;

// Base contract: Guarantees only general ticket identity
public interface TrainTicket {
  String getPnr();

  double getFarePaid();
}