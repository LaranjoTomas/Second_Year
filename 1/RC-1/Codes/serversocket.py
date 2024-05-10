import socket

# create a socket object
server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

# get local machine name
host = socket.gethostname()

port = 9999

# bind to the port
server_socket.bind((host, port))

# queue up to 5 requests
server_socket.listen(5)

# keep track of the total number of bytes received
total_bytes_received = 0

# keep track of the number of bytes received from each client
client_bytes_received = {}

while True:
    # establish a connection
    client_socket, addr = server_socket.accept()

    print(f"Got a connection from {addr}")
    
    # receive data from the client
    data = client_socket.recv(1024)
    
    # update the total and per-client byte counts
    total_bytes_received += len(data)
    if addr in client_bytes_received:
        client_bytes_received[addr] += len(data)
    else:
        client_bytes_received[addr] = len(data)
    
    # send the hostname and IP address of the server, along with the total and per-client byte counts, to the client
    hostname = socket.gethostname()
    ip_address = socket.gethostbyname(hostname)
    client_socket.send(f"Hostname: {hostname}\nIP address: {ip_address}\nTotal bytes received: {total_bytes_received}\nBytes received from {addr}: {client_bytes_received[addr]}".encode())

    client_socket.close()
