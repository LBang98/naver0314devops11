import React, { useState } from 'react';

const ParticipantInput = ({ onParticipantsSubmit }) => {
    const [participants, setParticipants] = useState(5);

    const handleSubmit = (e) => {
        e.preventDefault();
        onParticipantsSubmit(participants);
    };

    return (
        <div>
            <h1>사다리게임</h1>
            <form onSubmit={handleSubmit}>
                <label>
                    참여인원 수를 알려주세요. 24명까지 함께 할 수 있습니다.
                    <input
                        type="number"
                        value={participants}
                        onChange={(e) => setParticipants(e.target.value)}
                        min="2"
                        max="24"
                    />
                </label>
                <button type="submit">시작</button>
            </form>
        </div>
    );
};

export default ParticipantInput;
