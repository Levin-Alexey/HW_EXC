package password;

public class PasswordChecker {
    private int minLength;
    private int maxRepeat;


    public void setMinLength(int minLength) {
        if (minLength < 0) {
            throw new IllegalArgumentException("Минимальная длина пароля должна быть болше 0.");
        }
        this.minLength = minLength;
    }

    public void setMaxRepeat(int maxRepeat) {
        if (maxRepeat <= 0) {
            throw new IllegalArgumentException("Максимальное количество повторяющихся символов должно быть больше 0.");
        }
        this.maxRepeat = maxRepeat;
    }

    public boolean verify(String password) {
        if (minLength <= 0 || maxRepeat <= 0) {
            throw new IllegalStateException("Не все настройки установлены.");
        }
        if (password.length() < minLength) {
            return false;
        }
        int count = 1;
        for (int i = 1; i < password.length(); i++) {
            if (password.charAt(i) == password.charAt(i - 1)) {
                count++;
                if (count > maxRepeat) {
                    return false;
                }
            } else {
                count = 1;
            }
        }
        return true;
    }
}
