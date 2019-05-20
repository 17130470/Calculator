package calc;
/* Подключаем библиотеки для работы с текстовыми полями, метками, для создания графического окна */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EtchedBorder;

/* Создаем главный класс программы, реализующий интерфейс ActionListener, 
который отвечает за обработку события нажатия на кнопку.
*/
public class CalcAuthorization implements ActionListener{
	
	/* Создаем объект окна авторизации с помощью ключевого слова new */
    JFrame frameAut = new JFrame("Авторизация");
	/* Создаем объект панели с метками */
    JPanel panelLeftAut = new JPanel();
	/* Создаем объект панели с текстовыми полями */
    JPanel panelRightAut = new JPanel();
	/* Создаем объект панели с кнопками */
    JPanel panelBottomAut = new JPanel();
	/* Создаем массив текстовых полей */
    public JTextField[] fieldsAut = new JTextField[2];

     /* Добавляем конструктор класса */
    public CalcAuthorization() {
        /* Устанавливаем менеджер компоновки для панели с метками и выравнивание по вертикали */
        panelLeftAut.setLayout(new BoxLayout(panelLeftAut, BoxLayout.Y_AXIS));
        /* Устанавливаем размер панели с метками 250 на 300 пикселей */
        panelLeftAut.setPreferredSize(new Dimension(250, 300));

        /* Устанавливаем менеджер компоновки для панели с текстовыми полями и выравнивание по вертикали */
        panelRightAut.setLayout(new BoxLayout(panelRightAut, BoxLayout.Y_AXIS));
        /* Устанавливаем  размер 230 на 300 пикселей */
        panelRightAut.setPreferredSize(new Dimension(230,300));

        /* Добавляем метки к текстовым полям через метод addLabel */
        addLabel(panelLeftAut, "Логин:", Color.BLACK);
        addLabel(panelLeftAut, "Пароль:", Color.BLACK);
        /* Добавляем текстовые поля через цикл и записываем их в массив */
        for(int i = 0; i < fieldsAut.length; i++){
            if(fieldsAut.length >= 0){
                /* Записываем ссылку из метода в массив для дальнейшей работы с текстовым полем */
                fieldsAut[i] = addTextField(panelRightAut);}
        }

        /* Добавляем кнопку подтверждения авторизации */
        JButton signInAut = addButton(panelBottomAut, "Авторизоваться");
        /* Добавляем слушатель на событие нажатия */
        signInAut.addActionListener(this);
		/* Добавляем кнопку сброса */
        JButton resetAut = addButton(panelBottomAut, "Сброс");
        /* Добавляем слушатель на событие нажатия */
        resetAut.addActionListener(this);

        /* Делаем окно авторизации видимым */
        frameAut.setVisible(true);
        /* Устанавливаем действие при нажатии на крестик - завершение приложения */
        frameAut.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /* Устанавливаем начальное положение окна авторизации относительно центра экрана (по центру) */
        frameAut.setLocationRelativeTo(null);
        /* Устанавливаем размер окна авторизации (450 на 200) */
        frameAut.setSize(450,200);

        /* Добавляем панель с метками на окно авторизации */
        frameAut.add(panelLeftAut, BorderLayout.WEST);
		/* Добавляем панель с текстовыми полями на окно авторизации */
        frameAut.add(panelRightAut, BorderLayout.EAST);
		/* Добавляем панель с кнопками на окно авторизации */
        frameAut.add(panelBottomAut, BorderLayout.SOUTH);
		/* Запрещаем изменение размеров окна авторизации */
        frameAut.setResizable(false);
    }

    /* Метод добавления текстовых меток */
    public void addLabel(JComponent container, String name, Color color){
        /* Создаем объект текстовой метки */
        JLabel label = new JLabel(name);
        /* Устанавливаем максимально допустимый размер метки */
        label.setMaximumSize(new Dimension(200,20));
        /* Устанавливаем цвета текста метки */
        label.setForeground(color);
        /* Устанавливаем выравнивание метки по правому краю */
        label.setHorizontalAlignment(JLabel.RIGHT);
        /* Добавляем рамку вокруг метки */
        label.setBorder(new EtchedBorder());
        /* Добавляем метку на панель */
        container.add(label);
    }
