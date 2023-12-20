/*
Java'da "Employee" adında fabrika çalışanlarını temsil eden ve
 metotları ile çalışanların maaşlarını hesaplayan bir sınıf yazmalısınız.
  Bu sınıf 4 nitelik ve 5 metoda sahip olacaktır.

Sınıfın Nitelikleri

name : Çalışanın adı ve soyadı
salary : Çalışanın maaşı
workHours : Haftalık çalışma saati
hireYear : İşe başlangıç yılı
Sınıfın Metotları

Employee(name,salary,workHours,hireYear) : Kurucu metot olup 4 parametre alacaktır.
tax() : Maaşa uygulanan vergiyi hesaplayacaktır.
Çalışanın maaşı 1000 TL'den az ise vergi uygulanmayacaktır.
Çalışanın maaşı 1000 TL'den fazla ise maaşının %3'ü kadar vergi uygulanacaktır.


bonus() : Eğer çalışan haftada 40 saatten fazla çalışmış ise fazladan çalıştığı her saat başına 30 TL olacak şekilde bonus ücretleri hesaplayacaktır.

raiseSalary() : Çalışanın işe başlangıç yılına göre maaş artışını hesaplayacaktır. Şuan ki yılı 2021 olarak alın.
Eğer çalışan 10 yıldan az bir süredir çalışıyorsa maaşına %5 zam yapılacaktır.
Eğer çalışan 9 yıldan fazla ve 20 yıldan az çalışıyorsa maaşına %10 zam yapılacaktır.
Eğer çalışan 19 yıldan fazla çalışıyorsa %15 zam yapılacaktır.
toString() : Çalışana ait bilgileri ekrana bastıracaktır.

 */
 class Employee {
     String name;
     double salary;
     double workHours;
     int hireYear;
     int currentYear = 2023;
     int workYear = currentYear - hireYear;

// Employee constructor
     Employee(String name,double salary,int workHours, int hireYear){
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
    }

    // Calculate Tax method
    /*
    Çalışanın maaşı 1000 TL'den az ise vergi uygulanmayacaktır.
Çalışanın maaşı 1000 TL'den fazla ise maaşının %3'ü kadar vergi uygulanacaktır.
     */
    public double calcTax(){
        double taxAmount = (this.salary < 1000)? 0: 0.03;
        return taxAmount * this.salary;
    }

    // calculate bonus
    //Eğer çalışan haftada 40 saatten fazla çalışmış ise fazladan çalıştığı her saat başına 30 TL olacak şekilde bonus ücretleri hesaplayacaktır.

    public double bonus(){
        return this.workHours > 40 ? (this.workHours-40)* 30 : 0;
    }


    // calculate Salary raise
    /*
    Eğer çalışan 10 yıldan az bir süredir çalışıyorsa maaşına %5 zam yapılacaktır.
    Eğer çalışan 9 yıldan fazla ve 20 yıldan az çalışıyorsa maaşına %10 zam yapılacaktır.
    Eğer çalışan 19 yıldan fazla çalışıyorsa %15 zam yapılacaktır.
     */
    public double salaryRaise(){
        double bonusAmount = this.workYear < 10 ? 0.05 : this.workYear <= 19 ? 0.10 : 0.15;
        return this.salary*bonusAmount;
    }

    // toString() : Çalışana ait bilgileri ekrana bastıracaktır.

    public String printInfo(){

        double totalSalary = salary  + bonus() + salaryRaise() - calcTax();
            String printInfo =  "Name: " + name + "\n" +
                    "Salary: " + salary + "\n" +
                    "Work Hours: " + workHours + "\n" +
                    "Hire Year: " + hireYear + "\n" +
                    "Tax: " + calcTax() + "\n" +
                    "Bonus: " + bonus() + "\n" +
                    "Salary Increase: " + salaryRaise() + "\n" +
                    "Salary with Tax and Bonus: " + (totalSalary - salaryRaise()) + "\n" +
                    "Total Salary: " + totalSalary;

            return printInfo;
        }
    }

