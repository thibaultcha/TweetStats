/**
 */
package tweetstats.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import tweetstats.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TweetstatsFactoryImpl extends EFactoryImpl implements TweetstatsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TweetstatsFactory init() {
		try {
			TweetstatsFactory theTweetstatsFactory = (TweetstatsFactory)EPackage.Registry.INSTANCE.getEFactory(TweetstatsPackage.eNS_URI);
			if (theTweetstatsFactory != null) {
				return theTweetstatsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new TweetstatsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TweetstatsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case TweetstatsPackage.TWEET: return createTweet();
			case TweetstatsPackage.FETCH: return createFetch();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tweet createTweet() {
		TweetImpl tweet = new TweetImpl();
		return tweet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Fetch createFetch() {
		FetchImpl fetch = new FetchImpl();
		return fetch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TweetstatsPackage getTweetstatsPackage() {
		return (TweetstatsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static TweetstatsPackage getPackage() {
		return TweetstatsPackage.eINSTANCE;
	}

} //TweetstatsFactoryImpl
