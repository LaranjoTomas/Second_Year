import socket

# create a socket object
client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

# get local machine name
host = socket.gethostname()

port = 9999

# connection to hostname on the port.
client_socket.connect((host, port))

# receive data from the server
data = client_socket.recv(1024).decode()

print(data)

client_socket.close()
