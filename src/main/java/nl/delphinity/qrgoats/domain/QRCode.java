package nl.delphinity.qrgoats.domain;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
// Must have for the qrcode
import java.awt.image.BufferedImage;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class QRCode {

    private Integer genereerTijd;

    private BufferedImage afbeelding;

    private static final Logger logger = LogManager.getLogger(QRCode.class);

    public Integer getGenereerTijd() {
        return genereerTijd;
    }

    public void setGenereerTijd(Integer genereerTijd) {
        this.genereerTijd = genereerTijd;
    }

    public BufferedImage getAfbeelding() {
        return afbeelding;
    }

    public void setAfbeelding(BufferedImage afbeelding) {
        this.afbeelding = afbeelding;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QRCode qrCode)) return false;
        return Objects.equals(
                getGenereerTijd(),
                qrCode.getGenereerTijd()) && Objects.equals(getAfbeelding(),
                qrCode.getAfbeelding());
    }

    @Override
    public int hashCode() {

        final int prime = 31;
        int result = 1;

        result = prime * result + (genereerTijd == null ? 0 : genereerTijd.hashCode());
        result = prime * result + (afbeelding == null ? 0 : afbeelding.hashCode());

        return result;
    }

    @Override
    public String toString() {
        return "QRCode{" +
                "genereerTijd=" + genereerTijd +
                ", afbeelding=" + afbeelding +
                '}';
    }

    public static BufferedImage generateQR(String studentData) {
        try {
            // Initialize parameters
            Map<EncodeHintType, Object> hints = new HashMap<>();
            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
            hints.put(EncodeHintType.MARGIN, 2);

            // Creating the BitMatrix to save the world
            BitMatrix bitMatrix = new MultiFormatWriter().encode(studentData, BarcodeFormat.QR_CODE, 300, 300, hints);

            // Creating a BufferedImage from the BitMatrix
            BufferedImage bufferedImage = new BufferedImage(300, 300, BufferedImage.TYPE_INT_RGB);
            for (int x = 0; x < 300; x++) {
                for (int y = 0; y < 300; y++) {
                    bufferedImage.setRGB(x, y, bitMatrix.get(x, y) ? 0x000000 : 0xFFFFFF);
                }
            }

            // Returning the generated BufferedImage
            return bufferedImage;
        } catch (Exception e) {
            logger.error("Error generating QR code", e);
            return null; // returning null in case of an exception
        }
    }

    public boolean isOnTime(LocalDateTime checkTime) {
        LocalDateTime now = LocalDateTime.now();
        logger.info("Current time: {}", now);

        LocalDateTime morningTime = LocalDateTime.of(now.toLocalDate(), LocalTime.of(8, 31));
        logger.info("Morning time: {}", morningTime);

        LocalDateTime lunchStart = LocalDateTime.of(now.toLocalDate(), LocalTime.of(12, 5));
        logger.info("Lunch start time: {}", lunchStart);

        LocalDateTime lunchEnd = LocalDateTime.of(now.toLocalDate(), LocalTime.of(12, 36));
        logger.info("Lunch end time: {}", lunchEnd);

        LocalDateTime endOfScalda = LocalDateTime.of(now.toLocalDate(), LocalTime.of(14, 14));
        logger.info("End of Scalda time: {}", endOfScalda);

        if (checkTime.isBefore(morningTime)) {
            logger.info("Check time is before morning time");
            return true;
        } else if (checkTime.isBefore(lunchEnd) && checkTime.isAfter(lunchStart)) {
            logger.info("Check time is during lunch hours");
            return true;
        } else {
            logger.info("Check time is after end of Scalda");
            return checkTime.isAfter(endOfScalda);
        }
    }
}
