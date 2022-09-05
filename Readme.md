<div dir="rtl" align="justify">

چت روم
======

در این پروژه، که تقریبا در میانه‌ی مسیر کارآموزی شما است، توانمندی و تسلط شما بر مطالبی که تا کنون آموخته‌ای را می‌آزماید. با توجه به فضای کاری شرکت، قصد داریم جهت آشنایی بیشتر شما با فضای پیام‌رسانی، پیاده‌سازی یک چت‌روم ساده را به شما محول کنیم. همچنین مطالعه‌ی مطالب زیر برای این پروژه، توصیه می‌شود:
* [Logging](https://www.baeldung.com/spring-boot-logging)
* [Controller Advice](https://www.baeldung.com/spring-exceptions-json)
* [Scheduling](https://www.tutorialspoint.com/spring_boot/spring_boot_scheduling.htm)

## اصطلاحات

1. User
   
    هر کاربری که عضو سامانه است. کاربران می‌توانند در اتاق‌های مختلف به صورت هم‌زمان پیام رد و بدل کنند و هر کس مشخصات زیر را دارد:
    - نام کاربری (فرض کنید این ویژگی یکتا و پس از ثبت‌نام، تغییرناپذیر است)
   - نام نمایشی
   - آواتار
   - وضعیت (status/bio)
2. Room
   
   تمامی گفتگوهای این سامانه به اتاق‌ها محدود می‌شوند. می‌توانید برای اتاق‌ها محدودیت کاربر (حداقل ۵) قائل شوید. برای هر اتاق، مشخصات زیر مطلوب است:
   - نام اتاق (فرض کنید این ویژگی یکتا و پس از ساخت اتاق تغییرناپذیر است)
   - نام نمایشی
   - نام و تعداد اعضا
   - سازنده‌ی اتاق
3. Message
   
   به هر تعامل بین دو کاربر پیام گفته می‌شود. پیام‌ها تا زمانی مقرر (حداقل ۱۰ دقیقه) ویرایش‌پذیر هستند. همچنین برای سادگی، لازم نیست فرآیند پاسخ (Reply) را پیاده‌سازی کنید. هر پیام مشخصات زیر را دارد
   - id (برای کاربر نمایش داده نمی‌شود)
   - متن
   - زمان ارسال

## ویژگی‌ها

1. قابلیت ثبت‌نام
2. خروج خودکار کاربر درصورت عدم فعالیت به مدت ۱۵ دقیقه
3. مشاهده‌ی همه‌ی اتاق‌ها
4. قابلیت ساخت اتاق
5. قابلیت حذف اتاق توسط سازنده
6. قابلیت ترک اتاق
7. حذف خودکار اتاق پس از خروج سازنده
8. قابلیت ارسال پیام در اتاق
9. قابلیت ویرایش پیام
10. قابلیت مشاهده‌ی پروفایل یک کاربر
11. گزارش‌دهی هفتگی از وضعیت تعداد کاربرها،گروه‌ّها و پیام‌ها و ذخیره آن در فایل


##### توجه داشته باشید در صفحه‌ی چت اتاق‌ها تنها نام نمایشی کاربران نشان داده شود. همچنین برای هر پیام در گپ، زمان آن به دقت دقیقه نوشته شود. اما قابلیت ویرایش با دقت ثانیه اعمال شود.

## انتظارات

- استفاده از JDBC و Jedis (در صورت استفاده از پایگاه داده‌ی هر کدام)
- طراحی صحیح APIها
- استفاده‌ی مناسب از ابزازهای مدیریت اکسپشن در کنترلر و لاگ
- رعایت الگوهای طراحی و نکات تمیزی کد
- پیاده‌سازی تست‌ها با پوشش‌دهی حداقل ۸۰٪
- امکان مدیریت حداقل ۲۰ کاربر و ۴ اتاق هنگام آزمودن پروژه

</div>