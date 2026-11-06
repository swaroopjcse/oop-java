package designprinciples.railseva.good.lsp;

// Explicit capability interface for refundable tickets
public interface CancellableTrainTicket extends TrainTicket {
  double processCancellation();
}