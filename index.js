import { NativeModules } from 'react-native';

const { RNAcquireIo } = NativeModules;

class RNAcquireIoWrapper {
	UNREAD_MESSAGE_COUNT_UPDATE_EVENT_KEY = 'onAcquireIOUnreadMessageCountChange';

	init(accountId) {
		if (!accountId) {
			throw new Error('Account ID required');
		}

		return RNAcquireIo.init(accountId);
	}

	setVisitorDetail({ name, email, phone, ...payload }) {
		if (!name || !email || !phone) {
			throw new Error('Name, email, phone are required');
		}

		return RNAcquireIo.setVisitorDetail(name, email, phone, JSON.stringify(payload || {}));
	}

	setFireBaseToken(token) {
		return RNAcquireIo.setFireBaseToken(token);
	}

	startSupportChat() {
		return RNAcquireIo.startSupportChat();
	}

	logOut() {
		return RNAcquireIo.logOut();
	}
}

export default new RNAcquireIoWrapper();
