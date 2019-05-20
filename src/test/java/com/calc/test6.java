package calc;

/* Подключение библиотеки JUnit, позволяющая создавать тесты для программ */
import org.junit.Assert;
import org.junit.Test;

/* Создание класса, содержащего код теста */
public class test6 {
    
	/* Аннотация @Test указывает JUnit, что в методе находится код теста */
    @Test
    public void testCalculator(){
		/* Обработка исключения на случай возникновения ошибок в процессе выполнения теста */
        try{
			/* Создание объекта класса, содержащего программу */
            Calculator lc = new Calculator();
			/* Заполнение поля ввода программы определенной последовательностью символов */
            lc.fields[0].setText("GitHub Inc. is a web-based hosting service for version control using Git. It is mostly used for computer code.");
			/* Запуск программы */
            lc.calculate();
			/* Сравнение результата, выдаваемого программой, с ожидаемым значением */
            Assert.assertTrue("110".equals(lc.fields[1].getText()));
        }
		/* Код, выполняемый при возникновении ошибок в процессе выполнения теста */
        catch(Exception e){
			/* Неудачное завершение выполнения теста */
            Assert.fail("Проверьте правильность входных значений");
        }
    }
}