package br.com.araujoit.helpers;

import java.sql.Timestamp;
import java.time.Instant;

public interface DatetimeHelper {

	default Timestamp now() {
		//LocalDateTime localDateTime = LocalDateTime.now();
		//Instant instant = localDateTime.toInstant(ZoneOffset.UTC);
		//return Timestamp.from(instant);
		return Timestamp.from(Instant.now());
	}
}
