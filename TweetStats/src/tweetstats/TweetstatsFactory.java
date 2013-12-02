/**
 */
package tweetstats;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see tweetstats.TweetstatsPackage
 * @generated
 */
public interface TweetstatsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TweetstatsFactory eINSTANCE = tweetstats.impl.TweetstatsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Tweet</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tweet</em>'.
	 * @generated
	 */
	Tweet createTweet();

	/**
	 * Returns a new object of class '<em>Fetch</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fetch</em>'.
	 * @generated
	 */
	Fetch createFetch();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	TweetstatsPackage getTweetstatsPackage();

} //TweetstatsFactory
