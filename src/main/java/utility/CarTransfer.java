package utility;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import models.Car;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CarTransfer {

    public static Car carTransfer = null;
}
