package designModel.service;

import ch.qos.logback.core.joran.conditional.ElseAction;
import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;

public class TestLocalDataTime {
    // LocalDate LocalTime LocalDateTime
    @Test
    public void test(){
        // 获取当前系统时间
        LocalDateTime ldt = LocalDateTime.now();

        // 新生成一个指定日期
        LocalDateTime.of(2015,10,13,22,33);
        // 加一年
        LocalDateTime ldt1 = ldt.plusYears(2);
        // 减两个月
        LocalDateTime ldt2 = ldt.minusMonths(2);

        System.out.println(ldt.getMonthValue());
        System.out.println(ldt.getYear());
        System.out.println(ldt.getDayOfMonth());
    }

    // Instant ：时间戳（以Unix元年：1979年1月1日00：00：00到某个时间之间的毫秒值）
    @Test
    public void test2(){
        Instant now = Instant.now();
        System.out.println(now);

        OffsetDateTime offsetDateTime = now.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        System.out.println(now.toEpochMilli());
    }

    // Duration: 计算两个时间之间的间隔
    // Period: 计算两个日期之间的间隔
    @Test
    public void test3(){
        Instant ins = Instant.now();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Instant ins1 = Instant.now();
        Duration between = Duration.between(ins, ins1);
        System.out.println(between.toMillis());
        System.out.println("--------------------------");
        LocalDate ld = LocalDate.of(2020,1,14);
        LocalDate ld1 = LocalDate.now();

        Period between1 = Period.between(ld, ld1);
        System.out.println(between1);
        System.out.println(between1.getYears());
        System.out.println(between1.getMonths());
        System.out.println(between1.getDays());

    }

    // TemporalAdjuster : 时间矫正器
    // TemporalAdjusters ：工具类
    @Test
    public void test4(){
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        LocalDateTime localDateTime1 = localDateTime.withDayOfMonth(10);
        System.out.println(localDateTime1);

        LocalDateTime with = localDateTime.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        System.out.println(with);

        // 自定义到下一个工作日
        LocalDateTime ldt1 = localDateTime.with((l) -> {
            LocalDateTime ldt = (LocalDateTime) l;

            DayOfWeek dayOfWeek = ldt.getDayOfWeek();
            if (dayOfWeek.equals(DayOfWeek.FRIDAY)) {
                return ldt.plusDays(3);
            } else if (dayOfWeek.equals(DayOfWeek.SATURDAY)) {
                return ldt.plusDays(2);
            } else {
                return ldt.plusDays(1);
            }
        });

        System.out.println("下一个工作日："+ldt1);
    }

    // DateTimeFormatter : 格式化时间/日期
    @Test
    public void test5(){
        DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE_TIME;
        LocalDateTime ld = LocalDateTime.now();
        System.out.println(ld.format(dtf));

        System.out.println("----------------------");
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        String format = dtf2.format(ld);
        System.out.println(format);
        System.out.println("----------------------");
        LocalDateTime parse = ld.parse(format, dtf2);
        System.out.println(parse);
    }

    // ZonedDate\ZonedTime\ZonedDateTime
    @Test
    public void test6(){
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        availableZoneIds.forEach(System.out::println);
    }

    @Test
    public void test7(){
        LocalDateTime of = LocalDateTime.now(ZoneId.of("America/Cuiaba"));
        System.out.println(of);

        LocalDateTime now = LocalDateTime.now();
        ZonedDateTime zonedDateTime = now.atZone(ZoneId.of("America/Cuiaba"));
        System.out.println(zonedDateTime);
    }
}
