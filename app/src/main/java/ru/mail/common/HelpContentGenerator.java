package ru.mail.common;

public class HelpContentGenerator {
    public static String getContent() {
        return """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <title>Title</title>
                </head>
                <body>
                    <h3>
                        Вот тут инструкция для дяди Жени
                        Например
                    </h3>
                    <h3>
                        localhost:3466/product GET отдаёт все компании-список товаров
                    </h3>
                    <h3>
                        localhost:3466/post?product_name= POST удаляет товар с переданным именем
                    </h3>
                    <h3>
                        localhost:3466/company?product_name=New name product&company_name=Company new name&count=6 POST  добавляет продукт с этой компанией и количеством
                    </h3>
                    <h3>
                        localhost:3466/company?company_name=Company new name GET возвращает список товаров по имени этого производителя, в случае ошибки кидает 404
                    </h3>
                </body>
                </html>""";
    }
}
