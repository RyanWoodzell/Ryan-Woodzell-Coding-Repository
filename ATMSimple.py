
#   User should start with a balance of 10,000
balance = 10000

def ValidateMenuLimit(value):
    value = int(value)
    if(0 < value and value < 4):
        return True    
    return False   

def ValidateInteger(value):
    try:
        value = int(value)
        return True
    except:
        return False

def ValidateFloat(value):
    try:
        value = int(value)
        return True
    except:
        return False 

#   Create a function that validates the user input and user input must be in number range (between 1 and 5)
def ValidateMenuInput(choice):
    #   Input must be an integer
    if (ValidateInteger(choice) and ValidateMenuLimit(choice)):
        return True
    return False

#   ********** Allow the user to select what function they'd like to perform ********** 
def AtmMenu(): 
    print()
    print("-" * 60)
    print()
    print("Welcome to my ATM machine here are 4 options to choose from:")
    print()
    print("-" * 60)
    print()
    print("\t1.  Withdrawal")
    print("\t2.  Credit")
    print("\t3.  Balance")
    print("\t4.  Exit program")
    print()
    return input("Select from the options above:  ")

#   ********** Display the balance definition **********
def DisplayBalance(balance):
    print()
    print("*" * 7)
    print("\nThis is your balance: ",balance)
    print("*" * 7) 

#   **********  Withdraw methods definition **********
def ValidateWithdrawal(withdrawal):
    if ValidateFloat(withdrawal):
        return True
    else:
        print("\nPlease enter a dollar amount\n")
        return False

def HasWithdrawalFunds(withdrawal, balance):
    if(balance >= withdrawal):
        return True
    else:
        print("Please enter an amount that is within your funds")
        return False

#######################    
def Withdrawal(balance):    
    #   Show the user their balance before they withdrawal
    DisplayBalance(balance)

    #   The program should remember all transactions while running
    withDrawalAmount = int(input("What amount do you want to withdraw?:  "))

    #   Validate that the amount is a float value and don't allow the user to withdraw more money than they have
    if ValidateWithdrawal(withDrawalAmount) and HasWithdrawalFunds(withDrawalAmount, balance):
        print("Handle transactions")
        # Complete the transaction here
        balance=balance-withDrawalAmount
        print("You have succesfuly withdrew ", withDrawalAmount, " dollars and have ", balance, " Dollars left")
        return(balance)
    else:
        print("Handle invalid data")

#######################
#   ********** Define Deposit method definition **********
# Complete the transaction here
def deposit(balance):
    depositAmount = float(input("What amount do you want to deposit?:   "))
    if depositAmount<=0:
        print("Invalid deposit amount. Try again")
    else:
        balance = balance+depositAmount
        print("Your updated balance is: ",balance)
        return balance
#   ********** Exit Program definition **********
def ExitProgram():
    quit()


#######################
#   **********  Main Program definition ********** 
if __name__ == "__main__":

    while True:
        choice = AtmMenu()
        if ValidateMenuInput(choice):
            if choice == '2':
                balance = deposit(balance)
            if choice == '3':
                DisplayBalance(balance)
            if choice == '1':
                balance = Withdrawal(balance)
            if choice == '4':
                ExitProgram()
            

            # choice #2 is for deposit

            # choice # 3 is for diplaying the balance

            # choice #4 is to exit the program

        else:
            break       #   Exit program

    print()
    print("Thank you for using my ATM application!")
