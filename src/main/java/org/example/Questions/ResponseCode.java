package org.example.Questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

public class ResponseCode {
    public static Question<String> textoDe(Target elemento) {
        return actor -> Text.of(elemento).answeredBy(actor);
    }
}
