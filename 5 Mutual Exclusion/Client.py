import socket

# Client to send the token to server
def client():
    client_socket = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)

    token = "Unique Token"

    # Send token to the server on localhost and port 12345
    client_socket.sendto(token.encode(), ('127.0.0.1', 12345))
    
    print(f"Token sent to server: {token}")
    
    client_socket.close()

if __name__ == "__main__":
    client()

""" to run this, on one terminal put python server.py and the second one put python client.py"""