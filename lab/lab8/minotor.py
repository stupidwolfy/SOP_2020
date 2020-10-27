from tkinter import *

window = Tk()

# function
def fetch_client():
    print("Fetched..../n")

# design 
window.title("Eureka Monitor")
window.geometry("600x600") 
window.minsize(height=560) 

butt_a = Button(window, text="Refresh", command=fetch_client)
butt_a.pack()

# execute 
window.mainloop()