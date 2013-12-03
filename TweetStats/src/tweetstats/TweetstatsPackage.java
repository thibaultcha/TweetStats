/**
 */
package tweetstats;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see tweetstats.TweetstatsFactory
 * @model kind="package"
 * @generated
 */
public interface TweetstatsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "tweetstats";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://ece.fr/tweetstats";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "tweetstats";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TweetstatsPackage eINSTANCE = tweetstats.impl.TweetstatsPackageImpl.init();

	/**
	 * The meta object id for the '{@link tweetstats.impl.TweetImpl <em>Tweet</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tweetstats.impl.TweetImpl
	 * @see tweetstats.impl.TweetstatsPackageImpl#getTweet()
	 * @generated
	 */
	int TWEET = 0;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TWEET__MESSAGE = 0;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TWEET__DATE = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TWEET__ID = 2;

	/**
	 * The feature id for the '<em><b>Fetch</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TWEET__FETCH = 3;

	/**
	 * The number of structural features of the '<em>Tweet</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TWEET_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Tweet</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TWEET_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link tweetstats.impl.FetchImpl <em>Fetch</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tweetstats.impl.FetchImpl
	 * @see tweetstats.impl.TweetstatsPackageImpl#getFetch()
	 * @generated
	 */
	int FETCH = 1;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FETCH__DATE = 0;

	/**
	 * The feature id for the '<em><b>Last id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FETCH__LAST_ID = 1;

	/**
	 * The feature id for the '<em><b>Results</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FETCH__RESULTS = 2;

	/**
	 * The number of structural features of the '<em>Fetch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FETCH_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Fetch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FETCH_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link tweetstats.Tweet <em>Tweet</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tweet</em>'.
	 * @see tweetstats.Tweet
	 * @generated
	 */
	EClass getTweet();

	/**
	 * Returns the meta object for the attribute '{@link tweetstats.Tweet#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see tweetstats.Tweet#getMessage()
	 * @see #getTweet()
	 * @generated
	 */
	EAttribute getTweet_Message();

	/**
	 * Returns the meta object for the attribute '{@link tweetstats.Tweet#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see tweetstats.Tweet#getDate()
	 * @see #getTweet()
	 * @generated
	 */
	EAttribute getTweet_Date();

	/**
	 * Returns the meta object for the attribute '{@link tweetstats.Tweet#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see tweetstats.Tweet#getId()
	 * @see #getTweet()
	 * @generated
	 */
	EAttribute getTweet_Id();

	/**
	 * Returns the meta object for the reference '{@link tweetstats.Tweet#getFetch <em>Fetch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Fetch</em>'.
	 * @see tweetstats.Tweet#getFetch()
	 * @see #getTweet()
	 * @generated
	 */
	EReference getTweet_Fetch();

	/**
	 * Returns the meta object for class '{@link tweetstats.Fetch <em>Fetch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fetch</em>'.
	 * @see tweetstats.Fetch
	 * @generated
	 */
	EClass getFetch();

	/**
	 * Returns the meta object for the attribute '{@link tweetstats.Fetch#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see tweetstats.Fetch#getDate()
	 * @see #getFetch()
	 * @generated
	 */
	EAttribute getFetch_Date();

	/**
	 * Returns the meta object for the attribute '{@link tweetstats.Fetch#getLast_id <em>Last id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last id</em>'.
	 * @see tweetstats.Fetch#getLast_id()
	 * @see #getFetch()
	 * @generated
	 */
	EAttribute getFetch_Last_id();

	/**
	 * Returns the meta object for the reference list '{@link tweetstats.Fetch#getResults <em>Results</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Results</em>'.
	 * @see tweetstats.Fetch#getResults()
	 * @see #getFetch()
	 * @generated
	 */
	EReference getFetch_Results();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TweetstatsFactory getTweetstatsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link tweetstats.impl.TweetImpl <em>Tweet</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tweetstats.impl.TweetImpl
		 * @see tweetstats.impl.TweetstatsPackageImpl#getTweet()
		 * @generated
		 */
		EClass TWEET = eINSTANCE.getTweet();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TWEET__MESSAGE = eINSTANCE.getTweet_Message();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TWEET__DATE = eINSTANCE.getTweet_Date();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TWEET__ID = eINSTANCE.getTweet_Id();

		/**
		 * The meta object literal for the '<em><b>Fetch</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TWEET__FETCH = eINSTANCE.getTweet_Fetch();

		/**
		 * The meta object literal for the '{@link tweetstats.impl.FetchImpl <em>Fetch</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tweetstats.impl.FetchImpl
		 * @see tweetstats.impl.TweetstatsPackageImpl#getFetch()
		 * @generated
		 */
		EClass FETCH = eINSTANCE.getFetch();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FETCH__DATE = eINSTANCE.getFetch_Date();

		/**
		 * The meta object literal for the '<em><b>Last id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FETCH__LAST_ID = eINSTANCE.getFetch_Last_id();

		/**
		 * The meta object literal for the '<em><b>Results</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FETCH__RESULTS = eINSTANCE.getFetch_Results();

	}

} //TweetstatsPackage
