import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Filecopy {

    public static void main(String[] args) {
        // указываем пути до файлов первого и второго,
        // с первого будем копировать текст во второй
        String f_file = "C:\\Users\\stekkz\\Desktop\\ИТИП\\Labs\\4\\1.txt";
        String s_file = "C:\\Users\\stekkz\\Desktop\\ИТИП\\Labs\\4\\2.txt";

        try {
            copyFile(f_file, s_file);
            // если размер файла 0 то выдаем ошибку
            // если нет то даем мессейдж об успехе
            if (new File(f_file).length() > 0) {
                System.out.println("Содержимое файла 1 успешно вскопировано во 2-ой!");
            }
        // перехватываем исключение IOException, обычно оно возникает если
        // например файл не найден, ошибка при чтении файла и так далее
        // и в e.getMessage выдаем более полную ошибку
        } catch (IOException e) {
            System.out.println("При копировании файла произошла ошибка: " + e.getMessage());
        }
    }

    static void copyFile(String copy_from_here, String paste_here) throws IOException {
        File sourceFile = new File(copy_from_here);

        if (!sourceFile.exists()) {
            // если файла не существует выводи вот это
            throw new IOException("Исходный файл не существует.");
        }

        if (sourceFile.length() == 0) {
            // если файл пустой, выводим сообщение и завершаем метод
            System.out.println("Копируемый файл пуст.");
            return;
        }

        // открываем потоки для чтения первого и второго файлов
        try (
            FileInputStream copy_from_hereInputStream = new FileInputStream(sourceFile);
            FileOutputStream destinationFileOutputStream = new FileOutputStream(paste_here)
        ) {
            // создаем временный буфер чтобы хранить копируемые данные
            byte[] buffer = new byte[1024];
            int bytesRead;

            // читаем данные из первого файла и записываем их во второй файл
            while ((bytesRead = copy_from_hereInputStream.read(buffer)) > 0) {
                destinationFileOutputStream.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            // если происходит какая-то другая ошибка бросаем вот это 
            throw new IOException("Не удалось скопировать файл: " + e.getMessage(), e);
        }
    }

}