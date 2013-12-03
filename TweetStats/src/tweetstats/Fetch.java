/**
 */
package tweetstats;

import java.util.Date;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fetch</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tweetstats.Fetch#getDate <em>Date</em>}</li>
 *   <li>{@link tweetstats.Fetch#getLast_id <em>Last id</em>}</li>
 *   <li>{@link tweetstats.Fetch#getResults <em>Results</em>}</li>
 * </ul>
 * </p>
 *
 * @see tweetstats.TweetstatsPackage#getFetch()
 * @model
 * @generated
 */
public interface Fetch extends EObject {
	/**
	 * Returns the value of the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Date</em>' attribute.
	 * @see #setDate(Date)
	 * @see tweetstats.TweetstatsPackage#getFetch_Date()
	 * @model required="true"
	 * @generated
	 */
	Date getDate();

	/**
	 * Sets the value of the '{@link tweetstats.Fetch#getDate <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date</em>' attribute.
	 * @see #getDate()
	 * @generated
	 */
	void setDate(Date value);

	/**
	 * Returns the value of the '<em><b>Last id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last id</em>' attribute.
	 * @see #setLast_id(Long)
	 * @see tweetstats.TweetstatsPackage#getFetch_Last_id()
	 * @model required="true"
	 * @generated
	 */
	Long getLast_id();

	/**
	 * Sets the value of the '{@link tweetstats.Fetch#getLast_id <em>Last id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last id</em>' attribute.
	 * @see #getLast_id()
	 * @generated
	 */
	void setLast_id(Long value);

	/**
	 * Returns the value of the '<em><b>Results</b></em>' reference list.
	 * The list contents are of type {@link tweetstats.Tweet}.
	 * It is bidirectional and its opposite is '{@link tweetstats.Tweet#getFetch <em>Fetch</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Results</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Results</em>' reference list.
	 * @see tweetstats.TweetstatsPackage#getFetch_Results()
	 * @see tweetstats.Tweet#getFetch
	 * @model opposite="fetch" required="true"
	 * @generated
	 */
	EList<Tweet> getResults();

} // Fetch
