import java.time.LocalDate;

public class Student {
    private String nim;
    private String name;
    private LocalDate dob;
    private String alamat;

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

        public LocalDate getDOB() {
        return dob;
    }

      public void setDOB(LocalDate dob) {
        this.dob = dob;
    }

    
    
          public void setAlamat(String alamat) {
        this.alamat= alamat;
    }

        public String getAlamat() {
        return alamat;
    }


    @Override
    public String toString() {
        return String.format("Student {NIM=%s, Name=%s, DOB=%s, Alamat=%s}", nim, name,dob,alamat);
    }
}
