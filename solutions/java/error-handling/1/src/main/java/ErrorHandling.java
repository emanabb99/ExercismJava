import javax.swing.text.html.Option;
import java.io.IOException;
import java.util.Optional;

import static java.lang.Integer.parseInt;

class ErrorHandling {

    void handleErrorByThrowingIllegalArgumentException() {
        throw new IllegalArgumentException();
    }

    void handleErrorByThrowingIllegalArgumentExceptionWithDetailMessage(String message) {
        throw new IllegalArgumentException(message);
    }

    void handleErrorByThrowingAnyCheckedException() throws IOException {
        throw new IOException();
    }

    void handleErrorByThrowingAnyCheckedExceptionWithDetailMessage(String message) throws IOException {
        throw new IOException(message);
    }

    void handleErrorByThrowingAnyUncheckedException() {
        throw new ArrayIndexOutOfBoundsException();
    }

    void handleErrorByThrowingAnyUncheckedExceptionWithDetailMessage(String message) {
        throw new ArrayIndexOutOfBoundsException(message);
    }

    void handleErrorByThrowingCustomCheckedException() throws CustomCheckedException {
        throw new CustomCheckedException();
    }

    void handleErrorByThrowingCustomCheckedExceptionWithDetailMessage(String message) throws CustomCheckedException{
        throw new CustomCheckedException(message);
    }

    void handleErrorByThrowingCustomUncheckedException() {
        throw new CustomUncheckedException();
    }

    void handleErrorByThrowingCustomUncheckedExceptionWithDetailMessage(String message) {
        throw new CustomUncheckedException(message);
    }

    Optional<Integer> handleErrorByReturningOptionalInstance(String integer) {
        try {
            return Optional.of(parseInt(integer));
        }
        catch(Exception e) {
            return Optional.empty();
        }
    }

}
