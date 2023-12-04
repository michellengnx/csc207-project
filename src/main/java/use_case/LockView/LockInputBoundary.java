package use_case.LockView;

/**
 * Represents the input boundary for locking the view.
 * Implementations of this interface define the contract for locking operations.
 */
public interface LockInputBoundary {
    void execute(String viewName);
}
