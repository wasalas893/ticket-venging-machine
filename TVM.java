
import java.util.*;

public class TVM {

    public static void main(String []args){
		Scanner scan = new Scanner(System.in);
		Details details = new Details();	 
		Input_moneyNbalance im = new Input_moneyNbalance();	
				
		money_input_handle money_input = new money_input_handle();   				
		
		
		while(money_input.money_in_the_bank()==0){
			System.out.println("Not ready\nNeed to refill");
			System.out.println("How many notes for each below \nthousand \nfivehunderd \nhundred \nfifty \ntwenty \nten \nfive \ntwo \none");
			money_input.add_money(scan.nextInt(),scan.nextInt(),scan.nextInt(),scan.nextInt(),scan.nextInt(),scan.nextInt(),scan.nextInt(),scan.nextInt(),scan.nextInt());
		}
		System.out.println("Enter 1 to use\nEnter 2 to Admin");
		int choice = scan.nextInt();
		switch(choice){
			case 1:
				if(money_input.money_in_the_bank()==0){
					System.out.println("Not ready\nNeed to refill");
				}else{
					System.out.println("Ready");	
					details.passenger_details();
					int calculate_price1 = details.calculate_price();
					System.out.println("Your ticket price is : "+ calculate_price1);
					int sum_paid_money = money_input.sum_of_input_money(calculate_price1);  
				    int calculate_balace1 = im.calculate_balace(calculate_price1,sum_paid_money);
					System.out.println("Your balance is : "+ calculate_balace1);
					money_input.remove_money(calculate_balace1);
					money_input.print_money();	
				}
				break;
			case 2:
				System.out.println("1 : refill\n2 : see the remain money\n");
				int choice1 = scan.nextInt();
				if(choice1==1){
					System.out.println("How many notes for each below \nthousand \nfivehunderd \nhundred \nfifty \ntwenty \nten \nfive \ntwo \none");
					money_input.add_money(scan.nextInt(),scan.nextInt(),scan.nextInt(),scan.nextInt(),scan.nextInt(),scan.nextInt(),scan.nextInt(),scan.nextInt(),scan.nextInt());
				}else{
					money_input.print_money();

				}
				break;
				
		}
      
    }
    
}


class Details{
    static int destination;
    static int adults;
    static int children;
    
        public void passenger_details(){
            Scanner scan = new Scanner(System.in);
            
            do{
                System.out.print("Enter your  destination station as 1 to 20 : ");
                destination = scan.nextInt();
            }while(destination > 20);   
            
            System.out.print("\nHow many adults : ");
            adults = scan.nextInt();
            System.out.print("\nHow many children : ");
            children = scan.nextInt();
        }
        public int calculate_price(){
            int price = destination*adults*20 + destination*children*10; 
            
            return price;
        }
}

class Input_moneyNbalance{
		static int inputMoney;
	
	int check_input_money(int price){
		Scanner scanner = new Scanner(System.in);
 
		do{
           System.out.print("\nEnter the money : ");
           int inputMoney = scanner.nextInt();
		   this.inputMoney = inputMoney;
		}while(inputMoney < price);
		return inputMoney;
	}
	public int calculate_balace(int price,int inputMoney){

            int balance = inputMoney - price; 
            return balance;
        }
}

class money_input_handle{
	static int thousand;
	static int fivehunderd;
	static int hundred;
	static int fifty;
	static int twenty;
	static int ten;
	static int five;
	static int two;
	static int one;
		
	money_input_handle(int thousand,int fivehunderd,int hundred,int fifty,int twenty,int ten,int five,int two,int one){
		this.thousand = thousand;
		this.fivehunderd = fivehunderd;
		this.hundred = hundred;
		this.fifty = fifty;
		this.twenty = twenty;
		this.ten = ten;
		this.five = five;
		this.two = two;
		this.one = one;	
	}
	money_input_handle(){}
	
	void print_money(){
		System.out.println("thousand = "+thousand+ "\nfivehunderd = "+fivehunderd+"\nhundred = "+hundred+"\nfifty = "+fifty+ "\ntwenty = "+twenty+"\nten = "+ten+"\nfive = "+five+"\ntwo = "+two+"\none = "+one);
	}
	
	int sum_of_input_money(int calculate_price){
		Scanner scan = new Scanner(System.in);
		int sum;
		money_input_handle money_input = new money_input_handle();
		int arr[] = new int[9];
		String[] str = {"thousand" , "fivehundred","hundred","fifty","twenty","ten","five","two","one"};
			for(int i = 0; i < 9; i++){
				System.out.println(str[i]);
				arr[i] = scan.nextInt(); 
			}
			sum =arr[0]*1000 + arr[1]*500 + arr[2]*100+arr[3]*50+arr[4]*20+arr[5]*10+arr[6]*5+arr[7]*2+arr[8];
			
			if(calculate_price > sum){
				money_input.sum_of_input_money(calculate_price);
			}else{
				money_input.add_money(arr[0],arr[1],arr[2],arr[3],arr[4],arr[5],arr[6],arr[7],arr[8]);	
			}
		return sum;
	}
	
	void add_money(int thousand2,int fivehunderd2,int hundred2,int fifty2,int twenty2,int ten2,int five2,int two2,int one2){
		thousand += thousand2;
		fivehunderd += fivehunderd2;
		hundred += hundred2;
		fifty += fifty2;
		twenty += twenty2;
		ten += ten2;
		five += five2;
		two +=two2;
		one += one2;
	}
	
	static int sum=0;
	void remove_money(int balance){
		
		while(balance>=1000){
			sum+=1000;
			thousand-=1;
			balance-=1000;
		}
		while(balance >=500){
			sum+=500;
			fivehunderd-=1;
			balance-=500;
		}
		while(balance>=100){
			sum+=100;
			hundred-=1;
			balance-=100;
		}
		while(balance >=50){
			sum+=50;
			fifty-=1;
			balance-=50;
		}
		while(balance >=20){
			sum+=20;
			twenty-=1;
			balance-=20;
		}
		while(balance>=10){
			sum+=10;
			ten-=1;
			balance-=10;
		}
		while(balance >=5){
			sum+=5;
			five-=1;
			balance-=5;
		}
		while(balance >=2){
			sum+=2;
			two-=1;
			balance-=2;
		}
		while(balance>=1){
			sum+=1;
			one-=1;
			balance-=1;
		}
		
	
	}
 
	int money_in_the_bank(){
		if(thousand<3 ||fivehunderd<3 ||hundred<3 ||fifty<3 ||twenty<3 ||ten<3 ||five<3 ||two<3 ||one<3){
			
			return 0;
		}else
			return 1;
	}
	
	
}








