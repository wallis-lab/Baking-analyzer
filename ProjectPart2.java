//Wenlong Wang
import java.util.*;

class ChargCard
{
   private String cardNumber;
   private String name;
   public double balance;
    ChargCard()
   {
      cardNumber="";
      name="";
      balance=0; 
   }
    ChargCard(String n,String cn,double b)
   {
      name=n;
      cardNumber=cn;
      balance=b;
   }
   public String getcardNumber()
   {
      return cardNumber;
   }
   public String getname()
   {
      return name;
   }
   public double getbalance()
   {
      return balance;
   }
   
   
   public void setcardNumber(String cn)
   {
      cardNumber = cn;;
   }
   public void setname(String n)
   {
      name=n;;
   }
   public void setbalance(double b)
   {
      balance=b;
   }
   public String toString()
   {
      return "Card Information\n"+" Card holder name is :\t"+ this.name
          +"\tCard number is :\t"+this.cardNumber+"\tCard balance is :\t"+
          this.getbalance();
   }
}
class DebitCard extends ChargCard
{
   private double overdraftLimet;
   private double overdraftFee;
   private double feesIncurred;
   DebitCard()
   {
      overdraftLimet=100; 
      overdraftFee=50;
      feesIncurred=0;  
   }
   DebitCard(String n, String cn,double b,double ol)
   {
      super(n, cn,b);
      this.balance=b;
 
      overdraftLimet=ol; 
      overdraftFee=100;
      feesIncurred=50;     
   }
   public double getoverdraftLimet()
   {
      return overdraftLimet;
   }
   public double getoverdraftFee()
   {
      return overdraftFee;
   }
   public double getfeesIncurred()
   {
      return feesIncurred;
   }
   public void setoverdraftLimet(double ol)
   {
      if (overdraftLimet>0)
         overdraftLimet=ol;
   }
   public void setoverdraftFee(double of)
   {
      if (overdraftFee>0)
      
         overdraftFee=of;
   }
   public void setfeesIncurred(double fi)
   {
      if (feesIncurred>0)
         feesIncurred=fi;
   }
   public void purchase(double amount)
   {
      if(balance>amount)
      balance -=amount;
      else
      System.out.println("Purchase cannot big then balance");
   }
   public void increaseOverdraftLimit()
   {
      overdraftLimet+=100;
       
   }
   public void depositFunds(double amount)
   {
      balance+=amount;
   }
   public void withdrawFunds(double amount)
   {
      balance+=amount;
   }
   public void payFee()
   {
      feesIncurred =0;
   }
   public void increaseLemit(double ill)
   {
      overdraftLimet+=ill;
   }  
}
class CreditCard extends ChargCard
{
   private double spendingLimit;
   private double feesIncurred;
   CreditCard()
   {
      spendingLimit=0;
      feesIncurred=0;
   }
   CreditCard(String cn, String n, double b, double sl)
   {
      super(cn,n,b);
      spendingLimit=sl;
   }
   public double getspendingLimit()
   {
      return spendingLimit;   
   }
   public double getfeesIncurred()
   {
      return feesIncurred;   
   }
   public void setspendingLimit(double sl)
   {
      if (spendingLimit>0)
         spendingLimit=sl;
   }
   public void purchase(double amount)
   {
      if(balance>amount)
      balance +=amount;
      else
      System.out.println("Purchase cannot big then balance");
   }
   public void increaseSpendingLimit()
   {
      spendingLimit+=100;
   } 
   public void depositFunds(double amount)
   {
      if (balance >= amount)
         balance -= amount;
   }
   public void withdrawFunds(double amount)
   {
      if (amount < 1000) //credit can spending less $1000
         balance += amount;
   } 
   public void payFees()
   {
      feesIncurred = 0;
   } 
}
class ProjectPart2
{
   public static void main (String[] args)
   {
      String cardNumber1;
      String name1;
      int choose;
      int select1,select2;
      ChargCard charcard= new ChargCard();
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter you name: ");
      name1=sc.nextLine();
      
      System.out.println("Enter card number :");
      cardNumber1=sc.nextLine();
      System.out.println("Select you choose 1 for debit or 2 for credit.(0 exit) ");
      choose=sc.nextInt();
      
      DebitCard debitCard= new DebitCard(name1,cardNumber1,12000,0);// set debit balance is 12000
      
      CreditCard creditCard=new CreditCard(name1,cardNumber1,10000,0);// set credit balance is 10000
      
      while(choose!=0)
      {
         if (choose==1)
         {
            System.out.println("Select you operation on you Debit card");
            System.out.print("1. View Info\t"); 
            System.out.print("2. Purchase \t");
            System.out.print("3. Deposit \t");         
            System.out.print("4. Increase withdraw limit \t"); 
            System.out.print("5. Pay the money ");
            System.out.print("6. exit");
            System.out.println();
         
            select1=sc.nextInt();
            switch(select1)
            {
               case 1:
                  
                  System.out.println(debitCard);    
                  break;
               case 2:
                  System.out.println(" Enter the money");
               
                  debitCard.purchase(sc.nextDouble());
                  break;
               case 3:
                  System.out.println(" Make Deposit:");
               
                  debitCard.depositFunds(sc.nextDouble());
                  break;
               case 4:
                  System.out.println(" How much the spending limit should be?");
               
                  debitCard.increaseLemit(sc.nextDouble());
                  break;
               case 5:
                  debitCard.payFee();
                  break;
               case 6:
                  return;
               
               default:
                  break;
                     
            }
         }
         if (choose==2)
         {
            System.out.println("Select you operation on you credit card");
            System.out.print("1. View Info\t"); 
            System.out.print("2. Purchase \t");
            System.out.print("3. Deposit \t");         
            System.out.print("4. Increase withdraw limit \t"); 
            System.out.print("5. Pay the money \t");
            System.out.print("6. exit");
            System.out.println();
            select1=sc.nextInt();
            switch(select1)
            {
               case 1:
                  
                  System.out.println(creditCard);    
                  break;
               case 2:
                  System.out.println(" Enter the money");
               
                  creditCard.purchase(sc.nextDouble());
                  break;
               case 3:
                  System.out.println(" Make Deposit : ");
               
                  creditCard.depositFunds(sc.nextDouble());
                  break;
               case 4:
                  System.out.println(" How much the spending limit should be?");
               
                  creditCard.increaseSpendingLimit();
                  break;
               case 5:
                  creditCard.payFees();
                  break;
               case 6:
                  return;
               
               default:
                  break;
            }
         }
      }
   }
}