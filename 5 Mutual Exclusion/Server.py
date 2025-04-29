import socket

# Server to listen for token and handle data
def server():
    server_socket = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    server_socket.bind(('127.0.0.1', 12345))  # Listening on localhost and port 12345

    print("Server is listening...")
    
    while True:
        data, address = server_socket.recvfrom(1024)  # Receive data from client
        if data:
            print(f"Token received from {address}: {data.decode()}")
            # Process the received token (This can be your logic)
            print("Server processing token...")
            break  # End after processing the token (for this example)

    server_socket.close()
    print("Server stopped.")

if __name__ == "__main__":
    server()
