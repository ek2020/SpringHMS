package global.coda.hms.models;

/**
 * Custom Response entity to produce the response .
 *
 * @param <T> Generic Paramenter
 */
/**
 * @author ek
 *
 * @param <T>
 */
public class CustomResponse<T> {
  /**
   * The Status code.
   */
  private int statusCode;
  private String requestId;
  /**
   * The Data.
   */
  private T data;


  /**
   * Gets request id.
   *
   * @return the request id
   */
  public String getRequestId() {
    return requestId;
  }

  /**
   * Sets request id.
   *
   * @param requestId the request id
   */
  public void setRequestId(String requestId) {
    this.requestId = requestId;
  }

  /**
   * Instantiates a new Response entity.
   */
  public CustomResponse() {
  }


  /**
   * Gets status code.
   *
   * @return the status code
   */
  public int getStatusCode() {
    return statusCode;
  }

  /**
   * Sets status code.
   *
   * @param statusCode the status code
   * @return the status code
   */
  public CustomResponse setStatusCode(int statusCode) {
    this.statusCode = statusCode;
    return this;
  }

  /**
   * Gets data.
   *
   * @return the data
   */
  public T getData() {
    return data;
  }

  /**
   * Sets data.
   *
   * @param data the data
   * @return the data
   */
  public CustomResponse setData(T data) {
    this.data = data;
    return this;
  }
}